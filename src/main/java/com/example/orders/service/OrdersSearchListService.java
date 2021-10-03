package com.example.orders.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrderStatusEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.form.SearchForm;
import com.example.orders.repository.OrdersSearchListRepository;




@Service
public class OrdersSearchListService {
	
	@Autowired
	OrdersSearchListRepository repository;
	
	public Page<OrdersEntity> getPage(int pageNum, SearchForm form) {
		
		 //Where句の検索条件を管理できる箱を作成　where(null)は箱を作るための仕様
		Specification<OrdersEntity> searchConditions = Specification.where(null);
		
		/* IDで検索 */
    if (form.getOrderId() != 0) {
    	// root: 検索するテーブルの情報
    	// query: 自分でSQLを作成できる(今回は使わないが必ず記述)
    	// cb: どんな検索をしたいか設定する
    	// 第一引数にどこのなんのカラムに対して検索を行うか
    	// 第二引数は実際に検索したい値
    	
    	Specification<OrdersEntity> searchId = (root, query, cb) -> cb.equal(root.get("id"), form.getOrderId());
    	searchConditions = searchConditions.and(searchId);// andメソッドを使用して検索条件を追加
    }
		
    /* 単価Fromで検索 */
    if (form.getPriceFrom() != null && !form.getPriceFrom().isEmpty()) {
    	int priceFrom = Integer.parseInt(form.getPriceFrom());
    	Specification<OrdersEntity> searchPriceFrom = (root, query, cb) -> cb.greaterThanOrEqualTo((root.get("price")), (priceFrom));
      searchConditions = searchConditions.and(searchPriceFrom);
    }
    
    /* 単価Toで検索 */
    if (form.getPriceTo() != null && !form.getPriceTo().isEmpty()) {
    	int priceTo = Integer.parseInt(form.getPriceTo());
    	Specification<OrdersEntity> searchPriceTo = (root, query, cb) -> cb.lessThanOrEqualTo((root.get("price")), (priceTo));
      searchConditions = searchConditions.and(searchPriceTo);
    }
		
//    /* 会社名で検索 */
    if (form.getCompanyId() != 0) {
    	Specification<OrdersEntity> searchCompanyId = (root, query, cb) -> cb.equal(root.get("placesEntity").get("companiesEntity").get("companyId"), form.getCompanyId());
      searchConditions = searchConditions.and(searchCompanyId);
    }
		
//    /* ステータスで検索 */
    if (form.getStatus() != 0 ) {
    	Specification<OrdersEntity> searchStatus = (root, query, cb) -> cb.equal(root.get("orderStatusEntity").get("code"), form.getStatus());
      searchConditions = searchConditions.and(searchStatus);
    }
    
    
    /* 顧客名で検索 */
    if (form.getClientName() != null && !form.getClientName().isEmpty()) {
    	Specification<OrdersEntity> searchClientName = (root, query, cb) -> cb.like(root.get("clientName"), "%" + form.getClientName() + "%");
      searchConditions = searchConditions.and(searchClientName);
    }
    
    // 登録日（降順、昇順）
    Sort sort = Sort.by("id").ascending();
    if (form.isOrderDateSort() == true) {
    	sort = Sort.by("id").descending();
    } else if (form.isOrderDateSort() == false) {
    	sort = Sort.by("id").ascending();
    }

    PageRequest pageable = PageRequest.of(pageNum, 3, sort);
    Page<OrdersEntity> entityPageList = repository.getPage(searchConditions, pageable);
    return entityPageList;
	}
	
	public List<OrderStatusEntity> getAll() {
		List<OrderStatusEntity> orderStatusEntity = repository.selectAll();
		return orderStatusEntity;
	}
	
	public List<CompaniesEntity> getCompany() {
		List<CompaniesEntity> company = repository.selectCompany();
		return company;
	}
	
	public List<OrdersEntity> getId() {
		List<OrdersEntity> id = repository.getId();
		return id;
	}
	
	
	// 日付
	public List<String> getDate(Page<OrdersEntity> ordersEntityList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<String> timeList = new ArrayList<String>();
		for(OrdersEntity ordersEntitys : ordersEntityList) {
			String date = sdf.format(ordersEntitys.getCreatedAt());
			timeList.add(date);
		}
		return timeList;
	}
}
