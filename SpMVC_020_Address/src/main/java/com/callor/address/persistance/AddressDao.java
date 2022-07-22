package com.callor.address.persistance;

import java.util.List;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;

public interface AddressDao {
	
	public void create_addr_table();
	
	public List<AddressVO> selectAll();

	public AddressVO findById(Long a_seq);
	
	public List<AddressVO> searchAndPage(SearchPage searchPage);

	public int insert(AddressVO vo);
	public int update(AddressVO vo);
	public int delete(Long a_seq);
	

}
