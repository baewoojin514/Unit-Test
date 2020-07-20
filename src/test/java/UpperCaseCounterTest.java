import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;

        int numberOfUpperCaseCharinString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharinString, is(0));
        assertEquals(numberOfUpperCaseCharinString,0);
        assertTrue(numberOfUpperCaseCharinString==0);

        System.out.println("result :: " + numberOfUpperCaseCharinString);
        //null인 문자열에는 당연히 uppercase인 문자가 있을 수 없다. 따라서 모든 test를 이상없이 통과 한다.
    }

    //빈값울 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharactersInString, is(0));
        assertEquals(numberOfUpperCaseCharactersInString,0);
        assertTrue(numberOfUpperCaseCharactersInString==0);

        System.out.println("result :: " + numberOfUpperCaseCharactersInString);
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ() {
        String str = "ABCDEFGHIJ";
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertTrue(numberOfUpperCaseCharactersInString == 10);
        //assertTrue로 맞는 테스트 코드 작성
        assertFalse(numberOfUpperCaseCharactersInString==1);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        assertThat(numberOfUpperCaseCharactersInString, is(10));
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성

        //문자열에 대문자만 10개가 포함되어 있음으로 test를 이상 없이 통과 한다.
    }


    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI(){
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertTrue(result == 6);
        //assertTrue로 맞는 테스트 코드 작성
        assertFalse(result==1);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        assertThat(result, is(6));
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        System.out.println("result :: " + result);

        //대문자가 6개 포함된 문자열 임으로 test를 이상 없이 통과 한다.
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetZeroIndex() {
        new ArrayList<Object>().get(0);
        new ArrayList<Object>().indexOf(0);
        new ArrayList<Object>().remove(0);
    }

    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore
    @Test(timeout = 6000)
    public void testShouldRunInLimitedTime() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");

        Thread.sleep(1000);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");

        Thread.sleep(500);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");
        //3thread의 시간을 다 더해도 6000미만이기 때문에 test를 이상 없이 통과 한다.
    }
}
