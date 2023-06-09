package edu.ssafy.find_store.repository;

import edu.ssafy.find_store.entitiy.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query(value = "SELECT * \n" +
            "FROM (SELECT * FROM store \n" +
            "      WHERE longitude < :lon + 0.005\n" +
            "        and longitude > :lon - 0.005\n" +
            "        AND latitude < :lat + 0.005\n" +
            "        and latitude > :lat - 0.005) as F\n" +
            "where sqrt(power((:lat - F.latitude) * 90180, 2) + power((:lon - F.longitude) * 110940, 2)) < 200;", nativeQuery = true)
    List<Store> findStoreByDistance(@Param("lat") Float latitude, @Param("lon") Float longitude);
}
