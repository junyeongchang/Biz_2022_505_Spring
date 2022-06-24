package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistence.ListDao;
import com.callor.memo.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("listServiceV1")
public class ListServiceImplV1 implements ListService {

	@Autowired
	private ListDao listDao;
	@Autowired
	private String upPath;

	private final ResourceLoader resLoader;

	public ListServiceImplV1(ResourceLoader resLoader) {
		this.resLoader = resLoader;
	}

	@Override
	public void create_memo_table() {
		listDao.create_memo_table();
	}

	@Override
	public List<MemoVO> selectAll() {
		return listDao.selectAll();
	}

	@Override
	public MemoVO findById(Long id) {
		return listDao.findById(id);
	}

	@Override
	public int insert(MemoVO vo) {
		return 0;
	}

	@Override
	public int update(MemoVO vo) {
		return 0;
	}

	@Override
	public int delete(Long id) {
		listDao.delete(id);
		return 0;
	}

	@Override
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception {

		if (file == null) {
			String fileName = "";
			memoVO.setM_image(fileName);
			listDao.insert(memoVO);

			return null;
		} else {
			String fileName = file.getOriginalFilename();
			File dir = new File(upPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String uuStr = UUID.randomUUID().toString();
			uuStr += fileName;

			File upLoadFile = new File(upPath, uuStr);
			file.transferTo(upLoadFile);

			log.debug("uuStr", uuStr);
			memoVO.setM_image(uuStr);

			listDao.insert(memoVO);

			return null;
		}

	}

	@Override
	public void updateMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception {
		
		if (file != null) {
			String fileName = file.getOriginalFilename();

			File dir = new File(upPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String uuStr = UUID.randomUUID().toString();
			uuStr += fileName;

			File upLoadFile = new File(upPath, uuStr);
			file.transferTo(upLoadFile);

			memoVO.setM_image(uuStr);
			listDao.update(memoVO);
		} else {
			String fileName = "";
			memoVO.setM_image(fileName);
			listDao.update(memoVO);
		}

	}

}
