import 'package:flutter/cupertino.dart';

import 'package:flutter/material.dart';

class Review extends StatelessWidget {
  String pathImage = "";
  String name = "";
  int reviews = 0;
  int photos = 0;
  String comment = "";

  Review(this.pathImage, this.name, this.reviews, this.photos, this.comment);

  @override
  Widget build(BuildContext context) {
    final photo = Container(
      width: 80,
      height: 80,
      decoration: BoxDecoration(
          shape: BoxShape.circle,
          image: DecorationImage(
              fit: BoxFit.cover, image: AssetImage(this.pathImage))),
    );

    final name = Container(
      child: Text(
        this.name,
        style: TextStyle(
            fontFamily: "Lato", fontSize: 16, fontWeight: FontWeight.w900),
        textAlign: TextAlign.left,
      ),
    );

    final detail = Container(
      child: Text(
        "$reviews reviews . $photos photos",
        style: TextStyle(
            fontFamily: "Lato",
            fontSize: 10,
            fontWeight: FontWeight.w200,
            color: Colors.black),
        textAlign: TextAlign.left,
      ),
    );

    final comment = Container(
      child: Text(
        this.comment,
        style: TextStyle(
            fontFamily: "Lato",
            fontSize: 10,
            fontWeight: FontWeight.w900,
            color: Colors.black),
        textAlign: TextAlign.left,
      ),
    );

    final review = Container(
      margin: EdgeInsets.only(bottom: 20),
      child: Row(
        children: [
          photo,
          Column(
            children: [name, detail, comment],
          )
        ],
      ),
    );

    return review;
  }
}
