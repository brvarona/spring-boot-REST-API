package com.braianvarona.dto;

import java.util.List;
import java.util.Map;

import com.braianvarona.entity.Loan;

/**
 * 
 * @author Braian Varona
 *
 */

public class PageLoansDTO {

	private List<Loan> items;
	private Map<String, Integer> paging;
	
	public PageLoansDTO(List<Loan> items, Map<String, Integer> paging) {
		this.setItems(items);
		this.setPaging(paging);
	}
	
	public List<Loan> getItems() {
		return items;
	}
	public void setItems(List<Loan> items) {
		this.items = items;
	}
	public Map<String, Integer> getPaging() {
		return paging;
	}
	public void setPaging(Map<String, Integer> paging2) {
		this.paging = paging2;
	}	
}
