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
import com.alkemy.project.demo.dto.PersonajeDtoFilters;
import com.alkemy.project.demo.entity.PeliculaEntity;
import com.alkemy.project.demo.entity.PersonajeEntity;

@Component
public class PersonajeSpecifications {
	public Specification<PersonajeEntity> getByFilters(PersonajeDtoFilters filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getNombre())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                        )
                );
            }

            if (!CollectionUtils.isEmpty(filtersDTO.getPeliculas())) {
                Join<PeliculaEntity, PersonajeEntity> join = root.join("personajesAsociados", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(citiesId.in(filtersDTO.getPeliculas()));
            }
            

            if (filtersDTO.getEdad() > 0) {
                predicates.add(
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("edad")),
                                "%" + filtersDTO.getEdad() + "%"
                        )
                );
            }
            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
