package valerko.lgs.dao;

import java.util.List;

import valerko.lgs.domain.Bucket;
import valerko.lgs.shared.AbstractCRUD;

public interface BucketDao extends AbstractCRUD<Bucket> {
	public List<Bucket> readByUserId(Integer id);
}
