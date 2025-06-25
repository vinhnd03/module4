package com.vinhnd.quan_ly_blog.repository;

import com.vinhnd.quan_ly_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blogs where title like concat('%', :title, '%')", nativeQuery = true)
    Page<Blog> findByTitle(@Param("title") String title, Pageable pageable);
    Page<Blog> findBlogsByTitleContaining(String title, Pageable pageable);

    @Query(value = "select * from blogs where title like concat('%', :title, '%') and " +
            "(:cid IS NULL OR :cid = 0 OR category_id = :cid)", nativeQuery = true)
    Page<Blog> findByTitleAndCategory(@Param("title") String title, @Param("cid") Long categoryId, Pageable pageable);

}
