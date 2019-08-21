package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Before
    public void AsetUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void BtearDown()
    {
    }

    @Test
    public void CfindAll()
    {
    }

    @Test
    public void DgetCountStudentsInCourse()
    {
    }

    @Test
    public void Edelete()
    {
    }

    @Test
    public void FfindCourseById()
    {
        assertEquals("Java Back End", courseService.findCourseById(4)
                .getCoursename());
    }

    @Test(expected = EntityNotFoundException.class)
    public void GdeleteNotFound()
    {
        courseService.delete(100);
        assertEquals(6, courseService.findAll()
                .size());
    }

    @Test
    public void HdeleteFound()
    {
        courseService.delete(4);
        assertEquals(5, courseService.findAll().size());
    }
}