import 'package:flutter/material.dart';
import 'package:platzi_example/review.dart';

class ReviewList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final listReview = Container(
        margin: EdgeInsets.only(top: 15, left: 20),
        child: Column(
          children: <Widget>[
            Review("assets/images/user.jpg", "Anthony Bravo Berrio", 2, 5,
                "The best place for visit in winter!"),
            Review("assets/images/user.jpg", "Anthony Bravo Berrio", 2, 5,
                "The best place for visit in winter!"),
            Review("assets/images/user.jpg", "Anthony Bravo Berrio", 2, 5,
                "The best place for visit in winter!"),
            Review("assets/images/user.jpg", "Anthony Bravo Berrio", 2, 5,
                "The best place for visit in winter!")
          ],
        ));

    return listReview;
  }
}
