package edu.waa.classified.service;

import java.util.List;

import edu.waa.classified.model.User;
import edu.waa.classified.model.WishList;

public interface WishListService {
    public WishList saveWishList(WishList wishList);

    public List<WishList> findAllWishLists(int userId);

    public User findWishListById(int id);

    public boolean updateWishList(WishList wishList);

    public void deleteWishList(Integer userId, Integer productId);
}
