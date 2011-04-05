<?php
/*
Plugin Name: Sponsor students
Plugin URI: http://wordpress.org/#
Description: TODO
Author: ThoughtWorks
Version: 1.0
Author URI: www.thoughtworks.com
*/

// Tells WP to reroute "/students" and "/students/{id}" to our plugin
add_filter('init','do_rewrite_students');
function do_rewrite_students() {
    add_rewrite_rule('students$', 'index.php?plugin=students', 'top');
    add_rewrite_rule('students/(\d*)$', 'index.php?plugin=students&student_id=$matches[1]', 'top');
}

// Tell WP to recognise student Id parameter and plugin parameter
add_filter('query_vars','add_student_id_var');
function add_student_id_var($vars) {
    array_push($vars, 'student_id');
    array_push($vars, 'plugin');
    return $vars;
}

// Stores method for use in theme template file "students.php" - should be refactored into seperate class
global $studentsContentMethod;
$studentsContentMethod = '';

// All the magic. Displays content depending on parameters (which are determined by the path visited)
add_action('wp', 'show_students');
function show_students() {

    if (get_query_var('plugin') != 'students')
        return;
    
    global $studentsContentMethod;
    if (get_query_var('student_id') == '')
        $studentsContentMethod = 'listOfStudents';
    else
        $studentsContentMethod = 'showStudent';
    
	include(dirname(__FILE__). '/students-template.php');
	exit;
}

// method called on the template for rendering students
function listOfStudents() {
    $students = getStudentListFromApi();
    
    foreach ($students->student as $student)
        // TODO: Create a template file to generate html
        echo var_dump($student);
}

// method called on the template for rendering single student
function showStudent() {
    $student = getSingleStudentFromApi(get_query_var('student_id'));
    // TODO: Create a template file to generate html
    var_dump($student);
}

function getStudentListFromApi() {
    // TODO Path to API should be configurable
    return new SimpleXMLElement(file_get_contents("http://sukrupa.localhost/wp-content/plugins/sponsor-students/students.xml"));
}

function getSingleStudentFromApi($id) {
    // TODO Pass id to the API. Currently calls static file.
    return new SimpleXMLElement(file_get_contents("http://sukrupa.localhost/wp-content/plugins/sponsor-students/single-student.xml"));
}

?>
