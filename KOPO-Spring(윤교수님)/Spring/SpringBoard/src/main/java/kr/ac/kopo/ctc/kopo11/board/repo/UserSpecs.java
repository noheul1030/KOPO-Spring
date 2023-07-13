package kr.ac.kopo.ctc.kopo11.board.repo;

import java.util.*;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import kr.ac.kopo.ctc.kopo11.board.domain.Sample;

public class UserSpecs {
	public static Specification<Sample> search(Map<String, Object> filter){
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<>();
			filter.forEach((key,value) -> {
				switch (key) {
				case "" :
					predicates.add(builder.equal(root.get(key).as(String.class), value));
				}
			});
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
