package in.nebulatech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nebulatech.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{

}
