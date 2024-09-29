package com.be.cart.service;

import com.be.cart.domain.CartItemVO;
import com.be.cart.dto.req.CartItemReqDto;
import com.be.cart.dto.res.CartItemResDto;
import com.be.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartMapper cartMapper;

    @Override
    public List<CartItemResDto> getCartList(int userNum) {
        return cartMapper.getCartItemList(userNum)
                .stream().map(CartItemResDto::of).toList();
    }

    @Override
    public CartItemResDto addCartItem(CartItemReqDto cart) {
//        if(checkCartItem(cart)) throw new NotAvailableProductException("장바구니에 존재하는 상품입니다.");

        CartItemVO cartVO = cart.toVO();
        CartItemResDto cartResDto = CartItemResDto.of(cartVO);
        cartResDto.setCartId(cartMapper.addCartItem(cartVO));

        return cartResDto;
    }

    @Override
    public void deleteCartItem(int cartId) {
        cartMapper.deleteCartItem(cartId);
    }

    @Override
    public boolean checkCartItem(CartItemReqDto cart) {
        if(cartMapper.checkCartItem(cart.getUserNum(), cart.getProductId()) == null) return false;
        return true;
    }
}
