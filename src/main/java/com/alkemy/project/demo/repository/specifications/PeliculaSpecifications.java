package com.alkemy.project.demo.repository.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alkemy.project.demo.dto.PeliculaFiltersDTO;
import com.alkemy.project.demo.entity.GeneroEntity;
import com.alkemy.project.demo.entity.PeliculaEntity;

@Component
public class PeliculaSpecifications {
    public Specification<PeliculaEntity> getByFilters(PeliculaFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getNombre())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                        )
                );
            }

            if (!CollectionUtils.isEmpty(filtersDTO.getGeneros())) {
                Join<PeliculaEntity, GeneroEntity> join = root.join("generosAsociados", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(citiesId.in(filtersDTO.getGeneros()));
            }

            query.distinct(true);

            String orderByField = "titulo";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
