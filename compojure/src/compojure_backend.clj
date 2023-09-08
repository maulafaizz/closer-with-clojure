(ns compojure_backend 
  (:require [compojure.core :refer :all] 
            [compojure.route :as route] 
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]))

(defroutes app 
  (GET "/" [] "<h1>Hello World</h1>")
  (route/not-found "<h1>Page not found</h1>")
  )

(comment
  (run-jetty (wrap-reload (var app)) {:port 3001 :join? false})
  (defn destruct-ex [{{:keys [user-id]} :session}] 
    (str user-id))
  (defn destruct-simple [{:keys [session]}] 
    (str session))
  (def destruct-map {:session {:user-id 1}})
  (destruct-simple destruct-map)
  (destruct-ex destruct-map)
  )

