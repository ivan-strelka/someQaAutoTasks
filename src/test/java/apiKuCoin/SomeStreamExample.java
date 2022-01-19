package apiKuCoin;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static apiKuCoin.Constants.Currency.LOVE_USDT;
import static apiKuCoin.Constants.Currency.USDT;
import static apiKuCoin.Constants.EndPoints.ALL_TICKERS;
import static apiKuCoin.Constants.EndPoints.getParamAllTickers;
import static io.restassured.RestAssured.given;

public class SomeStreamExample {

    public List<TickerData> getTickers() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(ALL_TICKERS)
                .then().log().all()
                .extract().jsonPath().getList("data.ticker", TickerData.class);
    }

    @Test
    void checkCrypto() {
        List<TickerData> tickers = getTickers().stream().filter(x -> x.getSymbol().endsWith(USDT))
                .collect(Collectors.toList());

        Assertions.assertTrue(tickers.stream().allMatch(x -> x.getSymbol().endsWith(USDT)));
    }

    @Test
    void sortHighToLow() {
        List<TickerData> highToLow = getTickers().stream().filter(x -> x.getSymbol().endsWith(USDT))
                .sorted(new Comparator<TickerData>() {
                    @Override
                    public int compare(TickerData o1, TickerData o2) {
                        return o2.getChangeRate().compareTo(o1.getChangeRate());
                    }
                }).collect(Collectors.toList());

        List<TickerData> top10 = highToLow.stream().limit(10).collect(Collectors.toList());
        Assertions.assertEquals(top10.get(0).getSymbol(), LOVE_USDT);
        int f = 0;

    }

    @Test
    void sortHighToLow2() {
        List<TickerData> highToLow = getTickers().stream().filter(x -> x.getSymbol().endsWith(USDT))
                .sorted((o1, o2) -> o2.getChangeRate().compareTo(o1.getChangeRate())).collect(Collectors.toList());

        List<TickerData> top10 = highToLow.stream().limit(10).collect(Collectors.toList());
        Assertions.assertEquals(top10.get(0).getSymbol(), LOVE_USDT);
        int f = 0;

    }

    @Test
    void sortLowToHIgh() {
        List<TickerData> tickerDataStream = getTickers().stream().filter(x -> x.getSymbol().endsWith(USDT))
                .sorted(new TickerComparatorLow()).limit(10).collect(Collectors.toList());
        int a = 0;

    }

    @Test
    void lowerCases() {
        List<String> lowerCases = getTickers().stream().map(x -> x.getSymbol().toLowerCase())
                .collect(Collectors.toList());

        List<String> upperCase = lowerCases.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        List<String> upperCase2 = lowerCases.stream().map(String::toUpperCase).collect(Collectors.toList());
        int a = 0;
    }

    @Test
    void name() {
        System.out.println(getParamAllTickers("123"));
    }

    @Test
    void map() {
        Map<String, Float> usd = new HashMap<>();
        List<String> lowerCases = getTickers().stream().map(x -> x.getSymbol().toLowerCase())
                .collect(Collectors.toList());

        getTickers().forEach(x -> usd.put(x.getSymbol(), Float.parseFloat(x.getChangeRate())));

        List<TickerShort> shortList = new ArrayList<>();
        getTickers().forEach(x -> shortList.add(new TickerShort(x.getSymbol(), Float.parseFloat(x.getChangeRate()))));

        int a = 0;

    }
}
