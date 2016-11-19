
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
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[models.BeerDB.DrinkerInfo,List[String],List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(drinkerInfo: models.BeerDB.DrinkerInfo,
  beers: List[String], bars: List[String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.43*/("""

"""),_display_(/*4.2*/main("Edit Drinker Information: " + drinkerInfo.name)/*4.55*/ {_display_(Seq[Any](format.raw/*4.57*/(""" """)))}/*4.59*/ {_display_(Seq[Any](format.raw/*4.61*/("""
  """),format.raw/*5.3*/("""<form method="post" action=""""),_display_(/*5.32*/routes/*5.38*/.Application.updateDrinker()),format.raw/*5.66*/("""">
    <input type="hidden" name="name" value=""""),_display_(/*6.46*/drinkerInfo/*6.57*/.name),format.raw/*6.62*/(""""/>
    Address: <input type="text" name="address" value=""""),_display_(/*7.56*/drinkerInfo/*7.67*/.address),format.raw/*7.75*/(""""
                    size="20" maxlength="20"/><br/>
    Beer(s) liked:
    """),_display_(/*10.6*/for(beer <- beers) yield /*10.24*/ {_display_(Seq[Any](format.raw/*10.26*/("""
      """),format.raw/*11.7*/("""<input type="checkbox" name="BeersLiked/"""),_display_(/*11.48*/beer),format.raw/*11.52*/("""" value="1"
             """),_display_(/*12.15*/if(drinkerInfo.beersLiked.contains(beer))/*12.56*/ {_display_(Seq[Any](format.raw/*12.58*/("""checked""")))}),format.raw/*12.66*/("""/>"""),_display_(/*12.69*/beer),format.raw/*12.73*/("""
    """)))}),format.raw/*13.6*/("""<br/>
    Bar(s) frequented (times a week):
    <ul>
    """),_display_(/*16.6*/for(bar <- bars) yield /*16.22*/ {_display_(Seq[Any](format.raw/*16.24*/("""
    """),format.raw/*17.5*/("""<li>"""),_display_(/*17.10*/bar),format.raw/*17.13*/(""" """),format.raw/*17.14*/("""<input type="text" name="BarsFrequented/"""),_display_(/*17.55*/bar),format.raw/*17.58*/(""""
                    """),_display_(/*18.22*/if(drinkerInfo.barsFrequented.contains(bar))/*18.66*/ {_display_(Seq[Any](format.raw/*18.68*/("""
                      """),format.raw/*19.23*/("""value=""""),_display_(/*19.31*/drinkerInfo/*19.42*/.timesFrequented(drinkerInfo.barsFrequented.indexOf(bar))),format.raw/*19.99*/(""""
                    """)))}/*20.23*/else/*20.28*/{_display_(Seq[Any](format.raw/*20.29*/("""
                      """),format.raw/*21.23*/("""value="0"
                    """)))}),format.raw/*22.22*/("""
                    """),format.raw/*23.21*/("""size="1" maxlength="2"/></li>
    """)))}),format.raw/*24.6*/("""
    """),format.raw/*25.5*/("""</ul>
    <input type="reset" value="Reset"/>
    <input type="submit" value="Submit Update"/>
  </form>
""")))}),format.raw/*29.2*/("""
"""))}
  }

  def render(drinkerInfo:models.BeerDB.DrinkerInfo,beers:List[String],bars:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(drinkerInfo,beers,bars)

  def f:((models.BeerDB.DrinkerInfo,List[String],List[String]) => play.twirl.api.HtmlFormat.Appendable) = (drinkerInfo,beers,bars) => apply(drinkerInfo,beers,bars)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Nov 19 15:57:21 EST 2016
                  SOURCE: /opt/dbcourse/hitchhiker42/app/views/edit.scala.html
                  HASH: 8a697420238fc08a1cd1497f383eda1d2f06c11a
                  MATRIX: 767->1|938->84|966->87|1027->140|1066->142|1086->144|1125->146|1154->149|1209->178|1223->184|1271->212|1345->260|1364->271|1389->276|1474->335|1493->346|1521->354|1625->432|1659->450|1699->452|1733->459|1801->500|1826->504|1879->530|1929->571|1969->573|2008->581|2038->584|2063->588|2099->594|2183->652|2215->668|2255->670|2287->675|2319->680|2343->683|2372->684|2440->725|2464->728|2514->751|2567->795|2607->797|2658->820|2693->828|2713->839|2791->896|2833->920|2846->925|2885->926|2936->949|2998->980|3047->1001|3112->1036|3144->1041|3280->1147
                  LINES: 26->1|30->2|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|41->13|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|50->22|51->23|52->24|53->25|57->29
                  -- GENERATED --
              */
          