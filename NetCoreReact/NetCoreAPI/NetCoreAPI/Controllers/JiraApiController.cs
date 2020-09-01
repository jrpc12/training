using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using WorkerAPI.Models;
using System.Net.Http;
using System.Dynamic;
using System.Text.Json;
using System.Linq;
namespace WorkerAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class JiraApiController : ControllerBase
    {
        private readonly ILogger<JiraApiController> _logger;
         private static readonly string[] Summaries = new[]
        {
            "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
        };

        public JiraApiController(ILogger<JiraApiController> logger)
        {
            _logger = logger;           
        }
        
        //[HttpPost]
        public async Task<ResponseMessage> Post(List<string> jiracards)
        {
            ResponseMessage response = new ResponseMessage();

            dynamic payload = new ExpandoObject();
            payload.fields = new ExpandoObject();
            payload.fields.fixVersions = new List<Dictionary<string, object>>();
            payload.fields.fixVersions.Add( new Dictionary<string, object>()
            {
                { "self", "https://vancotech.atlassian.net/rest/api/2/version/11352"},
                { "id", "11352" },
                { "description", "" },
                { "name", "4.24.0.0" },
                { "archived", false },
                { "released", false },
                        
            });

            using (var httpClient = new HttpClient())
            {
                httpClient.DefaultRequestHeaders.Add("Authorization", "Basic anBhdEBhc2FwY29ubmVjdGVkLmNvbTpOSVZHMVhaSWZKT1FUcnk2WnlIZDUwM0U=");                

                foreach (string card in jiracards)
                {
                    string apiUrl = "https://vancotech.atlassian.net/rest/api/3/issue/" + card;
                    HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Put, apiUrl);                    
                    request.Content = new StringContent(JsonSerializer.Serialize(payload));
                    request.Content.Headers.ContentType = new System.Net.Http.Headers.MediaTypeHeaderValue("application/json");

                    using (var jiraRes = await httpClient.SendAsync(request))
                    {
                        string apiResponse = await jiraRes.Content.ReadAsStringAsync();
                        response.success = string.IsNullOrWhiteSpace(apiResponse);
                    }                    
                }
            }            

            return response;
            
        }
    }
}
