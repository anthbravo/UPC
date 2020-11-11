import 'package:flutter/material.dart';

class DescripcionPlace extends StatelessWidget {
  String titlePlace = "";
  int starPlace = 0;
  String descriptionPlace = "";

  DescripcionPlace(this.titlePlace, this.starPlace, this.descriptionPlace);

  @override
  Widget build(BuildContext context) {
    final title = Container(
      margin: EdgeInsets.only(right: 30),
      child: Text(
        titlePlace,
        style: TextStyle(
            fontFamily: "Lato", fontSize: 20, fontWeight: FontWeight.w900),
        textAlign: TextAlign.left,
      ),
    );

    final starBorder = Container(
      margin: EdgeInsets.only(right: 0),
      child: Icon(
        Icons.star_border,
        color: Colors.yellow,
        size: 15,
      ),
    );

    final starHalf = Container(
      margin: EdgeInsets.only(right: 0),
      child: Icon(
        Icons.star_half,
        color: Colors.yellow,
        size: 15,
      ),
    );

    final star = Container(
      margin: EdgeInsets.only(right: 0),
      child: Icon(
        Icons.star,
        color: Colors.yellow,
        size: 15,
      ),
    );

    final description = Container(
      child: Text(
        descriptionPlace,
        style: TextStyle(fontFamily: "Lato", fontSize: 10.0),
        textAlign: TextAlign.left,
      ),
    );

    final title_with_stars = Row(
      children: <Widget>[
        title,
        Row(
          children: [star, star, star, star, starHalf],
        )
      ],
    );

    final content = Container(
      margin: EdgeInsets.only(top: 320, left: 20, right: 20),
      child: Column(
        children: <Widget>[title_with_stars, description],
      ),
    );

    return content;
  }
}
