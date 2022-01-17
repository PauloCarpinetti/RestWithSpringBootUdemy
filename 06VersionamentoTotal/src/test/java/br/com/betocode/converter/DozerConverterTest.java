package br.com.betocode.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.betocode.converter.mock.MockPerson;
import br.com.betocode.data.model.Person;
import br.com.betocode.data.vo.PersonVO;

public class DozerConverterTest {
	
    MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", output.getUltimoNome());
        Assert.assertEquals("Addres Test0", output.getEndereco());
        Assert.assertEquals("Male", output.getGenero());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", outputZero.getUltimoNome());
        Assert.assertEquals("Addres Test0", outputZero.getEndereco());
        Assert.assertEquals("Male", outputZero.getGenero());
        
        PersonVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getPrimeiroNome());
        Assert.assertEquals("Last Name Test7", outputSeven.getUltimoNome());
        Assert.assertEquals("Addres Test7", outputSeven.getEndereco());
        Assert.assertEquals("Female", outputSeven.getGenero());
        
        PersonVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getPrimeiroNome());
        Assert.assertEquals("Last Name Test12", outputTwelve.getUltimoNome());
        Assert.assertEquals("Addres Test12", outputTwelve.getEndereco());
        Assert.assertEquals("Male", outputTwelve.getGenero());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", output.getUltimoNome());
        Assert.assertEquals("Addres Test0", output.getEndereco());
        Assert.assertEquals("Male", output.getGenero());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", outputZero.getUltimoNome());
        Assert.assertEquals("Addres Test0", outputZero.getEndereco());
        Assert.assertEquals("Male", outputZero.getGenero());
        
        Person outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getPrimeiroNome());
        Assert.assertEquals("Last Name Test7", outputSeven.getUltimoNome());
        Assert.assertEquals("Addres Test7", outputSeven.getEndereco());
        Assert.assertEquals("Female", outputSeven.getGenero());
        
        Person outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getPrimeiroNome());
        Assert.assertEquals("Last Name Test12", outputTwelve.getUltimoNome());
        Assert.assertEquals("Addres Test12", outputTwelve.getEndereco());
        Assert.assertEquals("Male", outputTwelve.getGenero());
    }
}

