// @SOURCE:/opt/dbcourse/hitchhiker42/conf/routes
// @HASH:b2deec6d9df1c7345c170ef07e65b7a8ea4777eb
// @DATE:Sat Nov 19 15:57:20 EST 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:5
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
        

// @LINE:6
private[this] lazy val controllers_Application_viewDrinker1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("drinker/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_Application_viewDrinker1_invoker = createInvoker(
controllers.Application.viewDrinker(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viewDrinker", Seq(classOf[String]),"GET", """""", Routes.prefix + """drinker/$name<[^/]+>"""))
        

// @LINE:7
private[this] lazy val controllers_Application_editDrinker2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit-drinker/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_Application_editDrinker2_invoker = createInvoker(
controllers.Application.editDrinker(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "editDrinker", Seq(classOf[String]),"GET", """""", Routes.prefix + """edit-drinker/$name<[^/]+>"""))
        

// @LINE:8
private[this] lazy val controllers_Application_updateDrinker3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update-drinker"))))
private[this] lazy val controllers_Application_updateDrinker3_invoker = createInvoker(
controllers.Application.updateDrinker(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateDrinker", Nil,"POST", """""", Routes.prefix + """update-drinker"""))
        

// @LINE:11
private[this] lazy val controllers_Assets_at4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """drinker/$name<[^/]+>""","""controllers.Application.viewDrinker(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit-drinker/$name<[^/]+>""","""controllers.Application.editDrinker(name:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update-drinker""","""controllers.Application.updateDrinker()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:5
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:6
case controllers_Application_viewDrinker1_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Application_viewDrinker1_invoker.call(controllers.Application.viewDrinker(name))
   }
}
        

// @LINE:7
case controllers_Application_editDrinker2_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Application_editDrinker2_invoker.call(controllers.Application.editDrinker(name))
   }
}
        

// @LINE:8
case controllers_Application_updateDrinker3_route(params) => {
   call { 
        controllers_Application_updateDrinker3_invoker.call(controllers.Application.updateDrinker())
   }
}
        

// @LINE:11
case controllers_Assets_at4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     