package com.be.portfolio.dto.req;

import com.be.portfolio.domain.PortfolioItemVO;
import com.be.portfolio.dto.res.PortfolioItemResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioItemReqDto {
    private int portfolioItemId;
    private int portfolioId;
    private int productId;
    private String stockCode;
    private int amount;
    private double expectedReturn;

    public PortfolioItemReqDto of(PortfolioItemVO vo) {
        return vo == null ? null : PortfolioItemReqDto.builder()
                .portfolioId(vo.getPortfolioId())
                .productId(vo.getProductId())
                .stockCode(vo.getStockCode())
                .amount(vo.getAmount())
                .expectedReturn(vo.getExpectedReturn())
                .build();
    }

    public static PortfolioItemReqDto of(PortfolioItemResDto resDto) {
        return resDto == null ? null : PortfolioItemReqDto.builder()
                .portfolioId(resDto.getPortfolioId())
                .productId(resDto.getProductId())
                .stockCode(resDto.getStockCode())
                .amount(resDto.getAmount())
                .expectedReturn(resDto.getExpectedReturn())
                .build();
    }

    public PortfolioItemVO toVo() {
        return PortfolioItemVO.builder()
                .portfolioId(portfolioId)
                .productId(productId)
                .stockCode(stockCode)
                .amount(amount)
                .expectedReturn(expectedReturn)
                .build();
    }
}
