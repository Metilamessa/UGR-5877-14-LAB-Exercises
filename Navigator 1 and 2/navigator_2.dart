import 'package:flutter/material.dart';

class Course {
  String code;
  String title;
  String description;

  Course({required this.code, required this.title, this.description = ""});
}

void main() {
  runApp(MaterialApp(
    home: CoursesListScreen(
      courses: [
        Course(
          code: 'Site 001',
          title: 'Introduction to Programming',
          description:
              'introduction to programming concepts and techniques.',
        ),
        Course(
          code: 'Site 002',
          title: 'Discrete Mathematics',
          description:
              'This course covers discrete mathematics topics such as logic, sets, and relations.',
        ),
        Course(
          code: 'Site 322',
          title: 'Mobile Programming',
          description:
              'This course focuses on developing mobile applications using various frameworks and technologies.',
        ),
      ],
      onTapped: (Course value) {},
    ),
  ));
}

class CoursesListScreen extends StatelessWidget {
  const CoursesListScreen({required this.courses, required this.onTapped});

  final List<Course> courses;
  final ValueChanged<Course> onTapped;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Courses List")),
      body: ListView(
        children: [
          for (var course in courses)
            ListTile(
              title: Text(course.title),
              subtitle: Text('Course Code: ${course.code}'),
              onTap: () => onTapped(course),
            ),
        ],
      ),
    );
  }
}

class CourseDetailsScreen extends StatelessWidget {
  final Course course;

  const CourseDetailsScreen({required this.course});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(course.title)),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              ' ${course.code}',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Text(
              'Description:',
              style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 5),
            Text(
              course.description,
              style: TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}
