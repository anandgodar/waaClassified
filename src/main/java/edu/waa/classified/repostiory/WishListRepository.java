package edu.waa.classified.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.waa.classified.model.WishList;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    @Query("SELECT W FROM WishList W WHERE userId= :userId")
    List<WishList> findWishList(@Param("userId") int userId);

//    @Query("DELETE WishList WHERE userId= :userId AND productId= :productId")
//    void deleteWishList(@Param("userId")int userId, @Param("productId")int productId);

    @Query("SELECT W FROM WishList W WHERE userId= :userId AND productId= :productId")
    WishList findWish(@Param("userId") int userId, @Param("productId") int productId);
}
