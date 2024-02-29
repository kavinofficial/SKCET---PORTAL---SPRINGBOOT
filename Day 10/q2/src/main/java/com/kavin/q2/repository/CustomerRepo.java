package com.kavin.q2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q2.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.city = :city")
    List<Customer> findByCity(@Param("city") String city);

    @Query("SELECT c FROM Customer c")
    List<Customer> findEveryone();

    @Query("SELECT c FROM Customer c WHERE c.customerId = :cId")
    Customer findById(@Param("cId") int cId);

    @Modifying
    @Query("UPDATE Customer c SET c.pincode = :pincode WHERE c.customerId = :cId")
    Customer putById(@Param("cId") int cId, @Param("pincode") int pincode);

    @Modifying
    @Query("DELETE FROM Customer c WHERE c.customerId =:id")
    boolean deleteById(@Param("id") int id);
}
