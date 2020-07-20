import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
        String empty = "";
        assertThat(empty, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 0.2));
        assertThat(Math.PI, closeTo(3.14,0.01));
        //error parameter는 오차범위를 의미한다.
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(2), anything());
        assertThat(null, anything());
        //어떤 값이던 참조할 수만 있다면 test가 이상 없이 진행된다.
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5));
        assertFalse(championList.size() == 6);
        championList.add(new Champion("champion","position"));
        assertTrue(championList.size() == 6);
        //size가 5인데 6인 경우 false 이기 때문에 test가 이상 없이 진행된다.
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));
        assertThat("바텀", is(supportChamp.getPosition()));
        assertThat("바텀", is(equalTo(supportChamp.getPosition())));
        assertThat("바텀", equalTo(supportChamp.getPosition()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        assertThat(championList.get(0), hasProperty("name"));
        assertThat(championList.get(0), hasProperty("name", equalTo("다리우스")));
        //champion list의 첫번째 요소의 name은 다리우스 position은 탑이다.
        assertThat(championList.get(1), hasProperty("position"));
        assertThat(championList.get(1), hasProperty("position", equalTo("정글")));
        assertThat(championList.get(1), hasProperty("name"));
        assertThat(championList.get(1), hasProperty("name", equalTo("리신")));

    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(0), hasToString("루시안"));
        assertThat(champListNames.get(1), hasToString("애쉬"));
        assertThat(champListNames.get(3), hasToString("갈리오"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1.get(0), samePropertyValuesAs(championNames2.get(0)));
        assertThat(championNames1.get(0), samePropertyValuesAs("루시안"));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat(champName, is("다리우스"));
        assertThat("다리우스", is(champName));
    }

}