package com.company.bookstore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.bookstore.models.Publisher;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
