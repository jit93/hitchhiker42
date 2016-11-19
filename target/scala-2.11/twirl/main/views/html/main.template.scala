
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(heading: String)(script: Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>Play/Java DB-Beers Example</title>
    <meta name="description" content="A sample Play/Java website for db-beers"/>
    <meta name="keywords" content="play, java, db-beers"/>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <link rel="stylesheet" href=""""),_display_(/*12.35*/routes/*12.41*/.Assets.at("stylesheets/style.css")),format.raw/*12.76*/("""" type="text/css" media="screen"/>
    """),_display_(/*13.6*/script),format.raw/*13.12*/("""
  """),format.raw/*14.3*/("""</head>
  <body>
    <h1><img src=""""),_display_(/*16.20*/routes/*16.26*/.Assets.at("images/beer.jpg")),format.raw/*16.55*/("""" style="float:right"/>Hitchhikers App</h1>
    <hr/>
    <h2 id="heading">"""),_display_(/*18.23*/heading),format.raw/*18.30*/("""</h2>
    <div id="content">"""),_display_(/*19.24*/content),format.raw/*19.31*/("""</div>
    <hr/>
  </body>
</html>
"""))}
  }

  def render(heading:String,script:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(heading)(script)(content)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (heading) => (script) => (content) => apply(heading)(script)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Nov 06 16:47:07 EST 2016
                  SOURCE: /home/catriona316/hitch/app/views/main.scala.html
                  HASH: 252f6aee69a9b11dccff9d2d892ba099e857a9a5
                  MATRIX: 732->1|866->47|894->49|1393->521|1408->527|1464->562|1530->602|1557->608|1587->611|1650->647|1665->653|1715->682|1818->758|1846->765|1902->794|1930->801
                  LINES: 26->1|29->1|31->3|40->12|40->12|40->12|41->13|41->13|42->14|44->16|44->16|44->16|46->18|46->18|47->19|47->19
                  -- GENERATED --
              */
          