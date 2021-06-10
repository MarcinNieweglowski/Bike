package com.marcin.bike.service;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import com.marcin.bike.repository.BikeExtrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BikeExtrasServiceImpl implements IBikeExtrasService {

    @Autowired
    private BikeExtrasRepository bikeExtrasRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<BikeExtras> list() {
        return this.bikeExtrasRepository.findAll();
    }

    @Override
    @Transactional
    public BikeExtras save(BikeExtras bikeExtras) {
        return this.bikeExtrasRepository.save(bikeExtras);
    }

    @Override
    @Transactional
    public BikeExtras get(Long id) {
        return this.bikeExtrasRepository.findById(id).get();
    }

    @Override
    public List<Bike> getByExtraName(String extraName) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Bike> criteriaQuery = criteriaBuilder.createQuery(Bike.class);
        Root<Bike> from = criteriaQuery.from(Bike.class);

        criteriaQuery.select(from).where(criteriaBuilder.equal(from.get("model").get("modelName"), extraName));

        TypedQuery<Bike> query = this.entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public BikeExtras edit(BikeExtras bikeExtras) {
        return this.save(bikeExtras);
    }

    @Override
    public List<BikeExtras> getSelected(Set<Long> bikeExtras) {
        return bikeExtras.stream().map(extra -> this.get(extra)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Optional<BikeExtras> bikeExtras = this.bikeExtrasRepository.findById(id);
        if (bikeExtras.isPresent())
            this.bikeExtrasRepository.delete(bikeExtras.get());
    }
}
