import 'package:flutter/material.dart';
import 'package:platzi_example/card_image.dart';

class CardImageList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final cardImageList = Container(
      height: 250,
      margin: EdgeInsets.only(top: 90),
      child: ListView(
        scrollDirection: Axis.horizontal,
        children: [
          CardImage("assets/images/place.jpg"),
          CardImage("assets/images/place.jpg"),
          CardImage("assets/images/place.jpg"),
          CardImage("assets/images/place.jpg"),
          CardImage("assets/images/place.jpg"),
          CardImage("assets/images/place.jpg")
        ],
      ),
    );

    return cardImageList;
  }
}
