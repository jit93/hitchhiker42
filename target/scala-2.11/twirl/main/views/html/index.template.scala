
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(drinkers: List[String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.26*/("""

"""),_display_(/*3.2*/main("All Drinkers")/*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/(""" """)))}/*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""
  """),format.raw/*4.3*/("""<p>Click on drinker below to view more information:
    <ul>
      """),_display_(/*6.8*/for(name <- drinkers) yield /*6.29*/ {_display_(Seq[Any](format.raw/*6.31*/("""
        """),format.raw/*7.9*/("""<li><a href=""""),_display_(/*7.23*/routes/*7.29*/.Application.viewDrinker(name)),format.raw/*7.59*/("""">"""),_display_(/*7.62*/name),format.raw/*7.66*/("""</a></li>
      """)))}),format.raw/*8.8*/("""
    """),format.raw/*9.5*/("""</ul>
  </p>
""")))}),format.raw/*11.2*/("""
"""))}
  }

  def render(drinkers:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(drinkers)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (drinkers) => apply(drinkers)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Nov 19 15:57:21 EST 2016
                  SOURCE: /opt/dbcourse/hitchhiker42/app/views/index.scala.html
                  HASH: 6b4d5df7b1a6bffe7a4a04f954c1877ed434765b
                  MATRIX: 729->1|841->25|869->28|897->48|936->50|956->52|995->54|1024->57|1117->125|1153->146|1192->148|1227->157|1267->171|1281->177|1331->207|1360->210|1384->214|1430->231|1461->236|1505->250
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|35->7|36->8|37->9|39->11
                  -- GENERATED --
              */
          