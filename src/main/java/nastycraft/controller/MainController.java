package nastycraft.controller;
 
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import nastycraft.model.Forum;
import nastycraft.model.Newsletter;
import nastycraft.model.Voting;
import nastycraft.model.Ranks;
import nastycraft.model.RanksOptions;
import nastycraft.service.EmailServiceImpl;
import nastycraft.service.ForumService;
import nastycraft.service.NewsletterService;
import nastycraft.service.RanksOptionsService;
import nastycraft.service.RanksService;
import nastycraft.service.UserService;
import nastycraft.service.VotingService;
 
@Controller
public class MainController {
 
 
    private static boolean allowUpdateRanks = false,allowUpdateVoting = false;
          
    @Autowired
    private UserService userService;
     
    @Autowired
    private ForumService forumService;
     
    @Autowired
    private VotingService votingService;
    
    @Autowired
    private RanksService ranksService;
    
    @Autowired
    private RanksOptionsService ranksOptionsService;
    
    @Autowired
    private NewsletterService newsletterService;
    
    @Autowired
    private EmailServiceImpl emailserviceimpl;
     
     
    @GetMapping("/")
    public String homeIndex(HttpServletRequest request) {
    	request.setAttribute("linkk", forumService.findAll());
        request.setAttribute("mode", "HOME_INDEX");
        request.setAttribute("display", "HOME");
        return "/nastycraft";
    }
     
    @GetMapping("/donations")
    public String donations(HttpServletRequest request) {
    	request.setAttribute("linkk", forumService.findAll());
    	request.setAttribute("ranksList", ranksService.findAll());
    	request.setAttribute("ranksOptionsList", ranksOptionsService.findAll()); 
        request.setAttribute("mode", "HOME_INDEX");
        request.setAttribute("display", "DONATIONS");
        return "/nastycraft";
    }
    
    @GetMapping("/voting")
    public String voting(HttpServletRequest request) {
    	request.setAttribute("linkk", forumService.findAll());
    	request.setAttribute("votingList", votingService.findAll()); 
        request.setAttribute("mode", "HOME_INDEX");
        request.setAttribute("display", "VOTING");
        return "/nastycraft";
    }
    
    @GetMapping("/test")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "HOME");
        return "index";
    }
     
    @PostMapping("/login-user")
    public String loginUser(@RequestParam String name,@RequestParam String password,HttpServletRequest request,HttpSession session) {
         
        if(userService.checkPassAndUser(name, password)){
            session.setAttribute("loggedIn", true);
            request.setAttribute("mode", "ADMINCP");
        }else{
            request.setAttribute("wrong_password", true);
            request.setAttribute("mode", "HOME");
        }
         
        return "index";
    }
     
     
     
    @GetMapping("/redirectLogIn")
    public RedirectView redirectLogIn(RedirectAttributes attributes,HttpServletRequest request) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        return new RedirectView("/test");
    }
//    @GetMapping("/redirectNewsletter")
//    public RedirectView redirectNewsletter(RedirectAttributes attributes,HttpServletRequest request) {
//        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
//        return new RedirectView("/");
//    }
     
     
    @GetMapping("/logOut")
    public String logOut(RedirectAttributes attributes,HttpServletRequest request, HttpSession session) {
        session.removeAttribute("loggedIn");
        request.setAttribute("log_out", true);
        request.setAttribute("mode", "HOME");
        return "index";
    }
     
    @GetMapping("/category")
    public String category(HttpServletRequest request,HttpSession session) {
        request.setAttribute("mode", "CATEGORY");
        return "index";
    }
    @GetMapping("/admincp")
    public String admincp(HttpServletRequest request,HttpSession session) {
        request.setAttribute("mode", "ADMINCP");
        return "index";
    }
     
    //forum methods
    @GetMapping("/newforum")
    public String editForum(HttpServletRequest request) {
        request.setAttribute("mode", "NEWFORUM");
        return "index";
    }
     
    @GetMapping("/forumcp")
    public String forumcp(HttpServletRequest request) {
        request.setAttribute("linkk", forumService.findAll()); 
        request.setAttribute("mode", "FORUM");
        return "index";
    }
     
    @PostMapping("/saveforum")
    public String saveForum(@ModelAttribute Forum forum,BindingResult bindingResult,HttpServletRequest request){
        forumService.saveForumLinks(forum);
        request.setAttribute("linkk", forumService.findAll()); 
        request.setAttribute("added", true);
        request.setAttribute("mode", "FORUM");
         
        return "index";
    }
     
    @GetMapping("/updateforum")
    public String updateForum(@RequestParam int id,HttpServletRequest request){
        request.setAttribute("links", forumService.findOne(id));
        request.setAttribute("mode", "UPDATEFORUM");
        return "index";
    }
     
    @GetMapping("/deleteforum")
    public String deleteForumLinks(@RequestParam int id,HttpServletRequest request){
        forumService.deleteForumLinks(id);
        request.setAttribute("linkk", forumService.findAll()); 
        request.setAttribute("added", true);
        request.setAttribute("mode", "FORUM");
        return "index";
    }
     
    //voting methods
        @GetMapping("/newvote")
        public String newVote(HttpServletRequest request) {
            request.setAttribute("mode", "NEWVOTE");
            return "index";
        }
         
        @PostMapping("/savevote")
        public String saveVote(@ModelAttribute Voting vote,BindingResult bindingResult,HttpServletRequest request){
           
            if(votingService.findAll().size() < 4 || allowUpdateVoting == true) {
            	votingService.saveVoting(vote);
            	request.setAttribute("addedv", true);
            }
            else {
            	  request.setAttribute("addNoMoreVote", true);
            }
            
            allowUpdateVoting = false;
            request.setAttribute("votingList", votingService.findAll());
            request.setAttribute("mode", "VOTE");
             
            return "index";
        }
        
        @GetMapping("/updatevoting")
        public String updateVote(@RequestParam int id,HttpServletRequest request){
            request.setAttribute("voteup", votingService.findOneVoting(id));
            allowUpdateVoting = true;
            
            request.setAttribute("mode", "UPDATEVOTE");
            return "index";
        }
         
        @GetMapping("/deletevoting")
        public String deleteVote(@RequestParam int id,HttpServletRequest request){
            votingService.deleteVoting(id);
            request.setAttribute("votingList", votingService.findAll()); 
            request.setAttribute("deletedv", true);
            request.setAttribute("mode", "VOTE");
            return "index";
        }
        
        @GetMapping("/votecp")
        public String votecp(HttpServletRequest request) {
        	  request.setAttribute("votingList", votingService.findAll()); 
              request.setAttribute("mode", "VOTE");
            return "index";
        }
        
        
       //email methods
        @GetMapping("/newsletter")
        public String newsletter(HttpServletRequest request) {
        	request.setAttribute("emailsavailable", emailserviceimpl.howManyEmails());
            request.setAttribute("mode", "NEWEMAIL");
            return "index";
        }
         
        @PostMapping("/sendnewsletter")
        public String sendnewsletter(@RequestParam String subject,@RequestParam String textarea,HttpServletRequest request,RedirectAttributes attributes){
        	
        	if(subject.equals("") || textarea.equals("")) {
        		attributes.addFlashAttribute("emptyFields", true);
        	}else {
        		emailserviceimpl.setSubject(subject);
            	emailserviceimpl.setTextarea(textarea);
            	
            	emailserviceimpl.sendEmails();
            	
            	attributes.addFlashAttribute("send", true);
        	}
        	
            request.setAttribute("mode", "NEWEMAIL");
            
            return "redirect:" + "/newsletter";
        }
        
        
      //ranks methods
        @GetMapping("/newrank")
        public String newRank(HttpServletRequest request) {
            request.setAttribute("mode", "NEWRANK");
            return "index";
        }
       
        @PostMapping("/saveranks")
        public String saveRanks(@ModelAttribute Ranks rank,BindingResult bindingResult,HttpServletRequest request){
            if(ranksService.findAll().size() < 4 || allowUpdateRanks == true) {
            	ranksService.saveRank(rank);
            	request.setAttribute("addedr", true);
            }
            else {
            	  request.setAttribute("addNoMore", true);
            }
            
          allowUpdateRanks = false;
      	  request.setAttribute("ranksList", ranksService.findAll());
          request.setAttribute("mode", "RANK");
          return "index";
        }
        
        @GetMapping("/updateranks")
        public String updateRanks(@RequestParam int id,HttpServletRequest request){
            request.setAttribute("ranksup", ranksService.findOneRank(id));       
            allowUpdateRanks = true;
            
            request.setAttribute("mode", "UPDATERANK");
            return "index";
        }
         
        @GetMapping("/deleteranks")
        public String deleteRanks(@RequestParam int id,HttpServletRequest request){
            ranksService.deleteRank(id);
            request.setAttribute("ranksList", ranksService.findAll()); 
            request.setAttribute("deletedr", true);
            request.setAttribute("mode", "RANK");
            return "index";
        }
        
        @GetMapping("/rankcp")
        public String rankcp(HttpServletRequest request) {
        	  request.setAttribute("ranksList", ranksService.findAll()); 
              request.setAttribute("mode", "RANK");
            return "index";
        }
        
        
        //ranks option methods
          @GetMapping("/newrankoption")
          public String newRankOption(HttpServletRequest request) {
              request.setAttribute("mode", "NEWRANKOPTION");
              return "index";
          }
          
          @GetMapping("/rankoptioncp")
          public String rankoptioncp(HttpServletRequest request) {
        	  request.setAttribute("ranksOptionsList", ranksOptionsService.findAll()); 
              request.setAttribute("mode", "RANKOPTION");
              return "index";
          }
          
          @PostMapping("/saveranksoption")
          public String saveRanksOption(@ModelAttribute RanksOptions rankOption,BindingResult bindingResult,HttpServletRequest request){
             
        	  if(rankOption.getHelper() == null) {
        		  rankOption.setHelper("red");
        	  }
        	  if(rankOption.getModerator() == null) {
        		  rankOption.setModerator("red");
        	  }
        	  if(rankOption.getAdmin() == null) {
        		  rankOption.setAdmin("red");
        	  }
        	  if(rankOption.getOperator() == null) {
        		  rankOption.setOperator("red");
        	  }
  
              	ranksOptionsService.saveRankOption(rankOption);
              	request.setAttribute("addedr", true);

        	request.setAttribute("ranksOptionsList", ranksOptionsService.findAll());
            request.setAttribute("mode", "RANKOPTION");
            return "index";
          }
          
          @GetMapping("/updaterankoption")
          public String updateRanksOption(@RequestParam int id,HttpServletRequest request){
              request.setAttribute("rankOptionsup", ranksOptionsService.findOneRank(id));       
              
              request.setAttribute("addedr", true);
              request.setAttribute("mode", "UPDATERANKOPTION");
              return "index";
          }
          
          @GetMapping("/deleterankoption")
          public String deleteRanksOptions(@RequestParam int id,HttpServletRequest request){
              ranksOptionsService.deleteRankOption(id);
              request.setAttribute("ranksOptionsList", ranksOptionsService.findAll());
              
              request.setAttribute("deletedr", true);
              request.setAttribute("mode", "RANKOPTION");
              return "index";
          }
          
          //newsletter messages
          @PostMapping("/savenewsletter")
          public String saveNewsletter(@ModelAttribute Newsletter email,BindingResult bindingResult,HttpServletRequest request,RedirectAttributes attributes) {
            
        	  String remoteAddr = "";
              if (request != null) {
                  remoteAddr = request.getHeader("X-FORWARDED-FOR");
                  if (remoteAddr == null || "".equals(remoteAddr)) {
                      remoteAddr = request.getRemoteAddr();
                  }
              }

              if(newsletterService.ipExist(remoteAddr)) {
            	  attributes.addFlashAttribute("ipExist", true);  
              }else if(newsletterService.emailExist(email.getEmail())) {
            	  attributes.addFlashAttribute("emailExist", true);
              }else if(!NewsletterService.isValidEmailAddress(email.getEmail())) {
            	  attributes.addFlashAttribute("added", false);
              }else {
              email.setIp(remoteAddr);
           	  newsletterService.saveNewsletter(email); 
              attributes.addFlashAttribute("added", true);
              }
	  
              return "redirect:" + "/";
          }
          
          
        
}