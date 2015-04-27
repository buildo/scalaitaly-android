package io.buildo.scalaitaly.utils;

import java.util.ArrayList;
import java.util.List;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.models.Room;
import io.buildo.scalaitaly.models.Speaker;
import io.buildo.scalaitaly.models.Talk;

/**
 * Created by andreaascari on 22/04/15.
 */
public class Talks {

    private static ArrayList<Talk> mTalks;

    public static List<Talk> getList() {
        return mTalks;
    }

    public static Talk get(int talkId) {

        for(int i = 0; i < mTalks.size(); i++) {
            if (mTalks.get(i).getId() == talkId)
                return mTalks.get(i);
        }
        return null;
    }

    public static void buildTalks() {
        mTalks = new ArrayList<Talk>();

        Room plenary = new Room(Room.PLENARY);
        Room roomA = new Room(Room.ROOM_A);
        Room roomB = new Room(Room.ROOM_B);

        // 1. The Evolution of Scala
        Talk theEvolutionOfScala = new Talk("The evolution of Scala");
        Speaker martinOdersky = new Speaker("Martin", "Odersky");
        martinOdersky.setAvatar(R.mipmap.martin_odersky);
        martinOdersky.setBio("Martin Odersky created the Scala programming language and is a professor in the programming research group at EPFL, the leading technical university in Switzerland. Throughout his career, Martin's singular objective has been to make the basic job of writing programs faster, easier and more enjoyable. In the process, he has personally written more lines of Java and Scala code than almost any other individual in the world. He wrote javac, the compiler used by the majority of today's Java programmers, and scalac, the compiler used by the fast-growing Scala community. He authored 'Programming in Scala' the best-selling book on Scala. Previously he has held positions at IBM Research, Yale University, University of Karlsruhe and University of South Australia, after having obtained his doctorate from ETH Zürich as a student of Niklaus Wirth, the creator of Pascal.");
        theEvolutionOfScala.addSpeaker(martinOdersky);
        theEvolutionOfScala.addRoom(plenary);

        addTalk(theEvolutionOfScala);

        // 2. Your microservice as a function
        Talk yourMicroserviceAsAFunction = new Talk("Your microservice as a function");
        Speaker philCalcado = new Speaker("Phil", "Calcado");
        philCalcado.setAvatar(R.mipmap.phil_calcado);
        philCalcado.setBio("Phil is the Director of Core Engineering at SoundCloud, his team is responsible for “keeping the trains running” in our microservices architecture. Before that he was the Director of Product Engineering at SoundCloud, and before joining SoundCloud he was a Lead Consultant for ThoughtWorks in Australia and the UK.");
        philCalcado.setCompany("SoundCloud");
        philCalcado.setTwitterUserName("pcalcado");

        yourMicroserviceAsAFunction.setBrief("SoundCloud's microservice architecture is built mostly in Scala, using Finagle as its distributed systems workhorse. Finagle is an RPC system for the JVM, and it is based on a pipes-and-filters architecture that maps very nicely to functional programming concepts of higher-order functions and combinators. Over the past few years we have found that it is extremely useful to go even a step further and think of microservices as functions themselves. In this talk let's explore how SoundCloud uses Scala and Finagle, and how we started thinking of a microservices architecture as a special case of a functional system.");
        yourMicroserviceAsAFunction.addSpeaker(philCalcado);
        yourMicroserviceAsAFunction.addRoom(plenary);
        yourMicroserviceAsAFunction.addTags("microservice", "finagle");

        addTalk(yourMicroserviceAsAFunction);

        // 3. Demystifying Type Inference

        Talk demystifyingTypeInference = new Talk("Demystifying Type Inference");
        demystifyingTypeInference.setId(2);
        Speaker jonPretty = new Speaker("Jon", "Pretty");
        jonPretty.setAvatar(R.mipmap.jon_pretty);
        jonPretty.setBio("Jon is a longstanding active member of the Scala community, having first used Scala in 2004. Since then, he's consulted on Scala in small businesses, large corporations and government projects. Since last summer, Jon has been on sabbatical to concentrate on Rapture, his family of open-source libraries and other Scala projects");
        jonPretty.setCompany("Propensive");
        jonPretty.setTwitterUserName("propensive");

        demystifyingTypeInference.setBrief("Understanding type inference in Scala is often seen as a dark art. How does the compiler sometimes manage to conjure up exactly the correct type from an horrendous tangle of generic method calls, while at other times it draws a blank at something that seems plainly obvious to everyone else? Jon will look at the variety of influences that guide Scala's type inference, why type ascriptions are sometimes required and sometimes not, and how you can design methods to maximize type inference at the call site. At the end of the talk, Scala's type inference will probably remain somewhat mysterious, but you should be closer to understanding where it works, where it doesn't, and the things to try when you get stuck.");
        demystifyingTypeInference.addSpeaker(jonPretty);
        demystifyingTypeInference.addTags("scala", "type system");
        demystifyingTypeInference.addRoom(plenary);


        addTalk(demystifyingTypeInference);



        // 4. Akka Streams

        Talk akkaStreams = new Talk("Akka Streams");
        Speaker mircoDotta = new Speaker("Mirco", "Dotta");
        mircoDotta.setAvatar(R.mipmap.mirco_dotta);
        mircoDotta.setBio("Mirco Dotta is a Software Engineer at Typesafe, and since January 2015 he is a contributor to the Play! Framework. He is also a long-standing committer to the Scala IDE for Eclipse, and has contributed to a few others development tools for Scala (included scalac - the Scala compiler). His interests include concurrency and testing. In his freetime, you'll see him next to a foosball table.");
        mircoDotta.setCompany("Typesafe");
        mircoDotta.setTwitterUserName("mircodotta");

        akkaStreams.setBrief("Akka Streams is an implementation of Reactive Streams, which is a standard for asynchronous stream processing with non-blocking backpressure on the JVM. In this talk we'll cover the rationale behind Reactive Streams, and explore the different building blocks available in Akka Streams. I'll use Scala for all coding examples, but Akka Streams also provides a full-fledged Java8 API. After this session you will be all set and ready to reap the benefits of using Akka Streams!");
        akkaStreams.addSpeaker(mircoDotta);
        akkaStreams.addTags("akkaStreams", "reactiveStream", "akka");
        akkaStreams.addRoom(roomA);


        addTalk(akkaStreams);



        // 5. An introduction to Akka and the Actor-Based Model

        Talk anIntroductionToAkkaAndTheActorBasedModel = new Talk("An introduction to Akka and the Actor-Based Model");

        Speaker danielaSfregola = new Speaker("Daniela", "Sfregola");
        danielaSfregola.setAvatar(R.mipmap.daniela_sfregola);
        danielaSfregola.setBio("Daniela Sfregola is a Software Engineer based in London. She has worked as Java developer before moving towards Scala. She is currently a Java / Scala Team Lead at Ovo Energy, a small but fast growing British Energy Provider, and passionate blogger at danielasfregola.com");
        danielaSfregola.setCompany("OVO Energy");
        danielaSfregola.setTwitterUserName("DanielaSfregola");

        anIntroductionToAkkaAndTheActorBasedModel.addSpeaker(danielaSfregola);
        anIntroductionToAkkaAndTheActorBasedModel.addRoom(roomB);
        anIntroductionToAkkaAndTheActorBasedModel.addTags("akka", "actorModel");


        addTalk(anIntroductionToAkkaAndTheActorBasedModel);

        // 6. Type Hackery: dependent types in Scala
        Talk typeHackeryDependentTypesInScala = new Talk("Type Hackery: dependent types in Scala");

        Speaker andreaFerretti = new Speaker("Andrea", "Ferretti");
        andreaFerretti.setAvatar(R.mipmap.andrea_ferretti);
        andreaFerretti.setBio("Andrea is a mathematician turned to programming, who found his sweet spot in the R&D group of UniCredit. There, he can be found proposing yet another programming language or trying to implement some more or less obscure paper");
        andreaFerretti.setCompany("UniCredit");
        andreaFerretti.setTwitterUserName("AndreaFerrett20");

        typeHackeryDependentTypesInScala.setBrief("An exploration of type level computations. First, I would introduce a few standard techniques to summon implicit instances for a given type, or detect type equality. Then, I would show how to use the type system to encode values and computations, with the examples of booleans and Peano naturals. Finally, the main goal of the talk would be to show how these type level encodings allow Scala to partially simulate some typical constructions of dependently-typed languages, such as fixed-size sequences, modular arithmetic and balanced trees. Many of these constructions have been explored before, and good references are the blog post series by Mark Harrah on type-level programming and the library Shapeless by Miles Sabin. The whole presentation is meant to be done inside an interactive iScala notebook, which can then be distributed to participants.");
        typeHackeryDependentTypesInScala.addSpeaker(andreaFerretti);
        typeHackeryDependentTypesInScala.addRoom(roomA);
        typeHackeryDependentTypesInScala.addTags("dependentTypes", "typeTheory");


        addTalk(typeHackeryDependentTypesInScala);


        // 7. A blueprint for a Scala-based microservices architecture
        Talk aBlueprintForAScalaBasedMicroserviceArchitecture = new Talk("A blueprint for a Scala-based microservices architecture");

        Speaker federicoFeroldi = new Speaker("Federico", "Feroldi");
        federicoFeroldi.setAvatar(R.mipmap.federico_feroldi);
        federicoFeroldi.setBio("Federico founded Measurence, Coderloop and Cloudify. He hacked at Gilt Groupe, Yahoo, Vodafone and a few other companies moving between 5 cities, 3 countries and 2 continents.");
        federicoFeroldi.setCompany("Measurance");
        federicoFeroldi.setTwitterUserName("cloudify");

        aBlueprintForAScalaBasedMicroserviceArchitecture.setBrief("During this session we will explore the component and the best practices behind a scalable Scala-based microservice architecture. We will see how to build a REST service with Akka and Spray, how to document its API with Swagger, how to package it with Sbt and Docker, how to deploy it with Mesos and Marathon and how to let him interact with other services with Bamboo. The talk with be full of code and practical tips.");
        aBlueprintForAScalaBasedMicroserviceArchitecture.addSpeaker(federicoFeroldi);
        aBlueprintForAScalaBasedMicroserviceArchitecture.addRoom(roomB);
        aBlueprintForAScalaBasedMicroserviceArchitecture.addTags("spray", "akka", "mesos");


        addTalk(aBlueprintForAScalaBasedMicroserviceArchitecture);

        // 8. Scala in increasingly demanding environments
        Talk scalaInIncreasinglyDemandingEnvironments = new Talk("Scala in increasingly demanding environments");

        Speaker robertoBentivoglio = new Speaker("Roberto", "Bentivoglio");
        robertoBentivoglio.setAvatar(R.mipmap.roberto_bentivoglio);
        robertoBentivoglio.setBio("Roberto graduated during 2009 at \"Università degli studi di Milano\" but he started to work with Java since 2005. He has been experimenting with Scala since 2009 and he is now using it on his everyday work. He spent four years in Switzerland where he worked for Credit Suisse Group. In the last years Roberto has worked on web applications following the Reactive Manifesto principles. He lives in Milano and he is now Head of IT Innovation at DATABIZ.");
        robertoBentivoglio.setCompany("Databiz");
        robertoBentivoglio.setTwitterUserName("robbenti");

        Speaker stefanoRocco = new Speaker("Stefano", "Rocco");
        stefanoRocco.setAvatar(R.mipmap.stefano_rocco);
        stefanoRocco.setBio("Stefano graduated in 2008 at the National College of Ireland, spent 10 years working for major investment banks. He has many years of experience in developing low-latency trading applications in Java. He likes experimenting with different programming languages such as Python, Erlang and Julia. He started working with Scala and Typesafe Reactive platform back in 2011. He is CTO at DATABIZ");
        stefanoRocco.setCompany("Databiz");

        scalaInIncreasinglyDemandingEnvironments.setBrief("The need to handle increasingly large volumes of data, to quickly drive decisions (via streaming technologies and machine learning algorithms), to scale systems effectively, to guarantee the right level of continuity, to float data across systems efficiently and others are becoming critical and challenging requirements. During this talk we’ll demonstrate how to design reactive, resilient, message driven and elastic applications by combining technologies such as Akka, Kakfa, Cassandra and Spark along with architectural patterns like CQRS, ES, etc. in order to achieve the previously mentioned needs.");
        scalaInIncreasinglyDemandingEnvironments.addSpeaker(robertoBentivoglio);
        scalaInIncreasinglyDemandingEnvironments.addSpeaker(stefanoRocco);
        scalaInIncreasinglyDemandingEnvironments.addRoom(roomA);
        scalaInIncreasinglyDemandingEnvironments.addTags("akka", "spark", "cqrs");
        scalaInIncreasinglyDemandingEnvironments.setTalkImage(R.mipmap.databiz);


        addTalk(scalaInIncreasinglyDemandingEnvironments);

        // 9. Building startups on Scala
        Talk buildingStartupsOnScala = new Talk("Building startups on Scala");

        Speaker andreaLattuada = new Speaker("Andrea", "Lattuada");
        andreaLattuada.setAvatar(R.mipmap.andrea_lattuada);
        andreaLattuada.setBio("Andrea is an eclectic engineer with a passion for well crafted software; co-founder of buildo, he focuses on developing stable platforms that enable rapid iteration. A former Google and Facebook intern where he gained experience as a site reliability / production engineer and currently pursuing a MSc degree in Computer Science with a focus on distributed systems at ETH Zürich.");
        andreaLattuada.setCompany("Buildo");
        andreaLattuada.setTwitterUserName("buildoHQ");

        Speaker gabrielePetronella = new Speaker("Gabriele", "Petronella");
        gabrielePetronella.setAvatar(R.mipmap.gabriele_petronella);
        gabrielePetronella.setBio("Gabriele has a strong entrepreneurial spirit. Before co-founding buildo, he founded Metwit, a crowdsourced-weather startup, in 2011, leading the iOS app development. He has also been working as research assistant at UIC and later as a mobile security consultant at Barclays. He loves studying and researching technologies and he is a functional programming devotee. He graduated from UIC with a Master in Computer Science and from Politecnico di Milano with a Master in Computer Engineering.");
        gabrielePetronella.setCompany("Buildo");
        gabrielePetronella.setTwitterUserName("buildoHQ");

        buildingStartupsOnScala.addSpeaker(andreaLattuada);
        buildingStartupsOnScala.addSpeaker(gabrielePetronella);
        buildingStartupsOnScala.setTalkImage(R.mipmap.buildo);
        buildingStartupsOnScala.addRoom(roomB);


        addTalk(buildingStartupsOnScala);


        // 10. Hands-on Scala.JS
        Talk handsonScalaJS = new Talk("Hands-on Scala.JS");

        Speaker albertoParo = new Speaker("Alberto", "Paro");
        albertoParo.setAvatar(R.mipmap.alberto_paro);
        albertoParo.setBio("CTO at Big Data Technologies and freelance consultant on Big Data and NoSQL solutions. He loves studying emerging solutions and applications mainly related Big Data processing, NoSQL, Natural Language Processing and neural networks.");
        albertoParo.setCompany("Big Data Technologies");
        albertoParo.setTwitterUserName("aparo77");

        handsonScalaJS.addSpeaker(albertoParo);
        handsonScalaJS.addRoom(roomA);
        handsonScalaJS.addTags("scalajs", "sbt", "javascript");


        addTalk(handsonScalaJS);


        // 11. Kernal64: A Commodore 64 emulator

        Talk kernal64ACommodore64Emulator = new Talk("Kernal64: A Commodore 64 emulator");
        Speaker alessandroAbbruzzetti = new Speaker("Alessandro", "Abbruzzetti");
        alessandroAbbruzzetti.setAvatar(R.mipmap.alessandro_abbruzzetti);
        alessandroAbbruzzetti.setBio("45-years-old, married with 2 kids. Graduated in Computer Engineering at Sapienza University in Roma. His passion for programming started at 13 with the mythical Commodore 64. He works for Ericsson dealing with software development for all telecom operators.");
        alessandroAbbruzzetti.setCompany("Ericsson");

        kernal64ACommodore64Emulator.setBrief("The presentation provides an introduction to the emulation world, in particular to the mythical Commodore 64 and its peripherals, like disk drive, printer, cartridges. To truly emulate the software written for this 8-bit home computer it is mandatory to be much accurate as possible and reproduce every single aspect of the real machine, starting from the chips that compose the hardware architecture. Beside the emulation topics the presentation faces some Scala performance issues that come up when you have to optimize low level operations. At the end I'll show you a demo where we'll see the emulator running a game and a demo-scene, one of the hardest software to emulate.");
        kernal64ACommodore64Emulator.addSpeaker(alessandroAbbruzzetti);
        kernal64ACommodore64Emulator.addRoom(roomB);
        kernal64ACommodore64Emulator.addTags("performance", "emulation", "scala");


        addTalk(kernal64ACommodore64Emulator);

    }

    public static void addTalk(Talk talk) {
        talk.setId(mTalks.size() + 1);
        mTalks.add(talk);
    }
}
