package valerko.lgs;

import valerko.lgs.dao.impl.BucketDaoImpl;
import valerko.lgs.dao.impl.ProductDaoImpl;
import valerko.lgs.dao.impl.UserDaoImpl;

public class Main {

	public static void main(String[] args) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		BucketDaoImpl bucketDaoImpl = new BucketDaoImpl();
		
		System.out.println();
		System.out.println("Users:");
		userDaoImpl.readAll().forEach(System.out::println);
		System.out.println();
		System.out.println("Products:");
		productDaoImpl.readAll().forEach(System.out::println);
		System.out.println();
		System.out.println("Buckets:");
		bucketDaoImpl.readAll().forEach(System.out::println);

	}

}
