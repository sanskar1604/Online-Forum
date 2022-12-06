package com.dxc.forum.service;

import java.util.List;


import com.dxc.forum.entity.DetailedData;

public interface DetailedDataService {


		public DetailedData addData(DetailedData data);
		

		public List<DetailedData> getAllData();


		public DetailedData getData(Long id);


		public DetailedData updateData(Long id, DetailedData data);
		

		public void deleteData(Long id);


}
