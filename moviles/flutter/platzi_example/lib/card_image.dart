import 'package:flutter/material.dart';

class CardImage extends StatelessWidget {
  String pathImage = "assets/images/place.jpg";

  CardImage(this.pathImage);
  @override
  Widget build(BuildContext context) {
    final cardImage = Container(
        width: 250,
        margin: EdgeInsets.only(left: 10, right: 10, bottom: 20),
        decoration: BoxDecoration(
            image: DecorationImage(
                fit: BoxFit.cover, image: AssetImage(this.pathImage)),
            borderRadius: BorderRadius.all(Radius.circular(15)),
            shape: BoxShape.rectangle,
            boxShadow: [
              BoxShadow(
                  color: Colors.black, blurRadius: 10, offset: Offset(0, 5))
            ]));

    return cardImage;
  }
}
