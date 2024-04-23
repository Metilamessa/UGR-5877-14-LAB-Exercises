import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_riverpod/flutter_riverpod.dart';

void main() {
  runApp(const ProviderScope(child: MyApp()));
}

class Post {
  final int id;
  final String title;
  final String body;

  Post({required this.id, required this.title, required this.body});

  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(
      id: json['id'],
      title: json['title'],
      body: json['body'],
    );
  }
}

final postsProvider = FutureProvider<List<Post>>((ref) async {
  final response =
      await http.get(Uri.parse('https://jsonplaceholder.typicode.com/posts'));
  if (response.statusCode == 200) {
    final List<dynamic> data = json.decode(response.body);
    return data.map((json) => Post.fromJson(json)).toList();
  } else {
    throw Exception('Failed to load posts');
  }
});

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Riverpod Example',
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends ConsumerWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    AsyncValue<List<Post>> postsAsyncValue = ref.watch(postsProvider);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Posts'),
      ),
      body: postsAsyncValue.when(
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (error, stackTrace) => Center(child: Text('Error: $error')),
        data: (posts) {
          return ListView.builder(
            itemCount: posts.length,
            itemBuilder: (context, index) {
              final post = posts[index];
              return ListTile(
                title: Text(post.title),
                onTap: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => PostDetailPage(post: post),
                    ),
                  );
                },
              );
            },
          );
        },
      ),
    );
  }
}

class PostDetailPage extends StatelessWidget {
  final Post post;

  const PostDetailPage({Key? key, required this.post}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(post.title),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              post.body,
              style: TextStyle(fontSize: 16.0),
            ),
          ],
        ),
      ),
    );
  }
}
