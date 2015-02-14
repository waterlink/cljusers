(ns cljusers.endpoint.auth
  (:require [compojure.core :refer :all]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.params :refer [wrap-params]]))

(defn stub-auth
  [_ password]
  (if (= "welcome" password)
    "THETOKEN"
    nil))

(defn auth-endpoint [config]
  (wrap-params
   (wrap-json-response
    (routes
     (PUT "/auth"
          [email password]
          {:body {:token (stub-auth email password)}})))))
