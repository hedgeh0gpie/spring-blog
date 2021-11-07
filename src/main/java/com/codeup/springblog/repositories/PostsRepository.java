package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    Post findByBody(String body);


//    @Query(nativeQuery = true, value="select * from posts where title like %:t%")
//    List<Post> findByTitleLike(@Param("t") String term);

//    @Query
//    Post findById(long id);

}
