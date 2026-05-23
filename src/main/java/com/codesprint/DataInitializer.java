package com.codesprint;

import com.codesprint.entity.Question;
import com.codesprint.entity.Subject;
import com.codesprint.repository.QuestionRepository;
import com.codesprint.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private SubjectRepository subjectRepository;
    @Autowired private QuestionRepository questionRepository;

    @Override
    public void run(String... args) {
        if (subjectRepository.count() > 0) return; // already seeded

        String[][] subjects = {
            {"Java", "fa-brands fa-java"},
            {"Python", "fa-brands fa-python"},
            {"Data Structures", "fa-solid fa-diagram-project"},
            {"Algorithms", "fa-solid fa-code"},
            {"SQL", "fa-solid fa-database"},
            {"Web Dev", "fa-solid fa-globe"},
            {"OOP", "fa-solid fa-cube"},
            {"System Design", "fa-solid fa-server"},
            {"Git & DevOps", "fa-brands fa-git-alt"},
            {"Operating Systems", "fa-solid fa-laptop-code"}
        };

        String[][][] questions = {
            {{"Reverse a String","Write a function to reverse a string in Java.","Easy"},
             {"Fibonacci Series","Print Fibonacci series up to N terms.","Easy"},
             {"Palindrome Check","Check if a given string is a palindrome.","Easy"},
             {"Factorial","Find factorial of a number using recursion.","Easy"},
             {"Array Sum","Find sum of all elements in an array.","Easy"}},
            {{"List Comprehension","Create a list of squares using list comprehension.","Easy"},
             {"Dictionary Operations","Perform CRUD operations on a Python dictionary.","Easy"},
             {"File Handling","Read and write a text file in Python.","Medium"},
             {"Lambda Functions","Use lambda to sort a list of tuples.","Medium"},
             {"Decorators","Write a simple logging decorator in Python.","Hard"}},
            {{"Stack Push/Pop","Implement push and pop operations for a stack.","Easy"},
             {"Queue Enqueue/Dequeue","Implement a queue using two stacks.","Medium"},
             {"Linked List Traversal","Traverse a singly linked list.","Easy"},
             {"Binary Search Tree","Insert and search in a BST.","Medium"},
             {"Graph BFS","Implement BFS traversal on a graph.","Hard"}},
            {{"Binary Search","Implement binary search on a sorted array.","Easy"},
             {"Bubble Sort","Implement bubble sort algorithm.","Easy"},
             {"Merge Sort","Implement merge sort and explain complexity.","Medium"},
             {"Quick Sort","Implement quick sort with pivot selection.","Medium"},
             {"Dynamic Programming","Solve 0/1 Knapsack problem using DP.","Hard"}},
            {{"SELECT Queries","Write SELECT queries with WHERE and ORDER BY.","Easy"},
             {"JOIN Operations","Write INNER JOIN, LEFT JOIN examples.","Medium"},
             {"Aggregation","Use GROUP BY with COUNT, SUM, AVG.","Medium"},
             {"Subqueries","Write a correlated subquery.","Hard"},
             {"Indexes","Explain and create indexes for performance.","Medium"}},
            {{"HTML Forms","Create a form with validation.","Easy"},
             {"CSS Flexbox","Build a responsive layout with flexbox.","Easy"},
             {"JavaScript DOM","Manipulate DOM elements with JS.","Medium"},
             {"Fetch API","Make API calls using fetch and handle responses.","Medium"},
             {"REST API Design","Design a RESTful API for a blog.","Hard"}},
            {{"Classes & Objects","Create a class with constructors and methods.","Easy"},
             {"Inheritance","Demonstrate single and multilevel inheritance.","Medium"},
             {"Polymorphism","Show method overloading and overriding.","Medium"},
             {"Encapsulation","Use getters/setters for data hiding.","Easy"},
             {"Abstraction","Create abstract classes and interfaces.","Medium"}},
            {{"URL Shortener","Design a URL shortener system.","Hard"},
             {"Rate Limiter","Design a rate limiter for an API.","Hard"},
             {"Cache System","Design an LRU cache.","Hard"},
             {"Message Queue","Design a message queue like Kafka.","Hard"},
             {"Load Balancer","Explain load balancing strategies.","Medium"}},
            {{"Git Basics","Explain git add, commit, push, pull.","Easy"},
             {"Branching","Create and merge branches in git.","Easy"},
             {"CI/CD Pipeline","Design a basic CI/CD pipeline.","Medium"},
             {"Docker Basics","Write a Dockerfile for a Java app.","Medium"},
             {"Kubernetes","Explain Kubernetes pods and services.","Hard"}},
            {{"Process vs Thread","Explain difference between process and thread.","Easy"},
             {"Deadlock","Explain deadlock and prevention strategies.","Medium"},
             {"Memory Management","Explain paging and segmentation.","Hard"},
             {"Scheduling Algorithms","Compare FCFS, SJF, Round Robin.","Medium"},
             {"Semaphores","Use semaphores for synchronization.","Hard"}}
        };

        for (int i = 0; i < subjects.length; i++) {
            Subject subject = new Subject();
            subject.setSubjectName(subjects[i][0]);
            subject.setIcon(subjects[i][1]);
            Subject saved = subjectRepository.save(subject);

            for (String[] q : questions[i]) {
                Question question = new Question();
                question.setTitle(q[0]);
                question.setDescription(q[1]);
                question.setDifficulty(q[2]);
                question.setSubject(saved);
                questionRepository.save(question);
            }
        }
    }
}
