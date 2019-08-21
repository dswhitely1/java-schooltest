package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class,
            secure = false)
public class CourseControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CourseService courseService;

    private ArrayList<Course> courseList;

    @Before
    public void setUp()
    {
        courseList = new ArrayList<>();
        Instructor i1 = new Instructor("Sally");
        i1.setInstructid(1);
        Instructor i2 = new Instructor("Lucy");
        i2.setInstructid(2);
        Instructor i3 = new Instructor("Charlie");
        i3.setInstructid(3);

        Course c1 = new Course("Data Science", i1);
        c1.setCourseid(1);
        Course c2 = new Course("JavaScript", i1);
        c2.setCourseid(2);
        Course c3 = new Course("Node.js", i1);
        c3.setCourseid(3);
        Course c4 = new Course("Java Back End", i2);
        c4.setCourseid(4);
        Course c5 = new Course("Mobile IOS", i2);
        c5.setCourseid(5);
        Course c6 = new Course("Mobile Android", i3);
        c6.setCourseid(6);

        Student s1 = new Student("John");
        s1.setStudid(1);
        ArrayList<Course> sc1 = new ArrayList<>();
        sc1.add(c1);
        sc1.add(c4);
        s1.setCourses(sc1);

        Student s2 = new Student("Julian");
        s2.setStudid(2);
        ArrayList<Course> sc2 = new ArrayList<>();
        sc2.add(c2);
        s1.setCourses(sc2);

        Student s3 = new Student("Mary");
        s3.setStudid(3);
        ArrayList<Course> sc3 = new ArrayList<>();
        sc3.add(c3);
        sc3.add(c1);
        sc3.add(c6);
        s3.setCourses(sc3);

        Student s4 = new Student("Julian");
        s4.setStudid(4);
        Student s5 = new Student("Tyler");
        s5.setStudid(5);
        Student s6 = new Student("Kim");
        s6.setStudid(6);
        Student s7 = new Student("Juan");
        s7.setStudid(7);
        Student s8 = new Student("Robby");
        s8.setStudid(8);
        Student s9 = new Student("Roberto");
        s9.setStudid(9);
        Student s10 = new Student("Bob");
        s10.setStudid(10);
        Student s11 = new Student("Liz");
        s11.setStudid(11);
        Student s12 = new Student("June");
        s12.setStudid(12);
        Student s13 = new Student("April");
        s13.setStudid(13);

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
        courseList.add(c5);
        courseList.add(c6);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void listAllCourses() throws Exception
    {
        String apiUrl = "/courses/courses";
        Mockito.when(courseService.findAll()).thenReturn(courseList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(courseList);
        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    public void getCountStudentsInCourses()
    {
    }

    @Test
    public void deleteCourseById()
    {
    }
}