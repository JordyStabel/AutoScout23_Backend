package models;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.dal.*;
import autoscoutbackend.models.Make;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FailTest {

    @Test
    public void failThisTest() {

        int value1 = 5;
        int value2 = 10;

        Assert.assertEquals(value1, value2);
    }
}
