import 'package:flutter/material.dart';

class GradientBack extends StatelessWidget {
  String title = "Title";

  GradientBack(this.title);

  @override
  Widget build(BuildContext context) {
    final title = Text(this.title,
        style: TextStyle(
            color: Colors.white,
            fontSize: 30,
            fontFamily: "Lato",
            fontWeight: FontWeight.bold));

    final gradientBack = Container(
      height: 250,
      decoration: BoxDecoration(
        gradient: LinearGradient(
            colors: [Color(0xFF4268D3), Color(0xFF584CD1)],
            begin: FractionalOffset(0.2, 0.0),
            end: FractionalOffset(1, 0.6),
            stops: [0, 0.6],
            tileMode: TileMode.clamp),
      ),
      alignment: Alignment(-0.9, -0.6),
      child: title,
    );

    return gradientBack;
  }
}
