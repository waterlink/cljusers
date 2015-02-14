(ns cljusers.endpoint.auth-test
  (:require [com.stuartsierra.component :as component]
            [clojure.test :refer :all]
            [peridot.core :refer :all]
            [cljusers.endpoint.auth :as auth]
            [cheshire.core :as json]))

(def handler
  (auth/auth-endpoint {}))

(defn authenticate-and-get-token
  [state email password]
  (-> state
      (request "/auth"
               :request-method :put
               :params {:email email :password password})
      (:response)
      (:body)
      (json/parse-string)
      (get "token")))

(deftest authenticate-test
  (testing "STUB authenticate with email and password"
    (let [token (-> (session handler)
                    (authenticate-and-get-token "john@example.org" "welcome"))]
      (is (= "THETOKEN" token))))

  (testing "STUB fail authenticate with email and password"
    (let [token (-> (session handler)
                    (authenticate-and-get-token "john@example.org" "wrong"))]
      (is (= nil token)))))
