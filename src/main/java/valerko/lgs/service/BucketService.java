package valerko.lgs.service;

import java.util.List;

import valerko.lgs.domain.Bucket;
import valerko.lgs.shared.AbstractCRUD;

public interface BucketService extends AbstractCRUD<Bucket>{
	public List<Bucket> readByUserId(Integer id);

}
