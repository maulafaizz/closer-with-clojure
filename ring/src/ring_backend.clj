(ns ring_backend
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.json :refer [wrap-json-response]])
  )

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World!"})

(defn handler-json [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body {:remoteAddr (request :remote-addr)}})

(def app (wrap-json-response handler-json))

(comment
  (run-jetty (wrap-reload (var handler)) {:port 3000
                     :join? false})
  (run-jetty (wrap-reload (var app)) {:port 4000
                                      :join? false})
  (println (System/getProperty "java.class.path"))
  )