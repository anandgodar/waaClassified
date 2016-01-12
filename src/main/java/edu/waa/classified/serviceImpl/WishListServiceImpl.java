package edu.waa.classified.serviceImpl;

import edu.waa.classified.model.User;
import edu.waa.classified.model.WishList;
import edu.waa.classified.repostiory.WishListRepository;
import edu.waa.classified.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {

    @Autowired
    WishListRepository wishListRepository;

    @Override
    public WishList saveWishList(WishList wishList) {
        DateFormat df = new SimpleDateFormat("dd-MM-yy");
        Date dateobj = new Date();
        df.format(dateobj);
        wishList.setLastModified(dateobj);
        return wishListRepository.save(wishList);
    }

    @Override
    public List<WishList> findAllWishLists(int userId) {
        return wishListRepository.findWishList(userId);

    }

    @Override
    public User findWishListById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateWishList(WishList wishList) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteWishList(Integer userId, Integer productId) {
        WishList wish = wishListRepository.findWish(userId, productId);
        wishListRepository.delete(wish);
    }


}
