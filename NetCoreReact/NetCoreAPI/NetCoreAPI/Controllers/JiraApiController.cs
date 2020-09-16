using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using NetCoreAPI.Models;
using System.Net.Http;
using System.Dynamic;
using System.Text.Json;
using System.Linq;
using Microsoft.Extensions.Configuration;

namespace NetCoreAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class JiraApiController : ControllerBase
    {
        private readonly ILogger<JiraApiController> _logger;
        private readonly IConfiguration _config;

        public JiraApiController(ILogger<JiraApiController> logger, IConfiguration config)
        {
            _logger = logger;
            _config = config;
        }
        
        //[HttpPost]
        public async Task<ResponseMessage> Post(List<string> jiracards)
        {
            ResponseMessage response = new ResponseMessage();

            string sprintVersion = "1";
            dynamic payload = new ExpandoObject();
            payload.fields = new ExpandoObject();
            payload.fields.fixVersions = new List<Dictionary<string, object>>();
            payload.fields.fixVersions.Add( new Dictionary<string, object>()
            {
                { "self", "https://vancotech.atlassian.net/rest/api/2/version/11352"},
                { "id", "11352" },
                { "description", "" },
                { "name", sprintVersion },
                { "archived", false },
                { "released", false },
                        
            });

            string gitToken = _config.GetSection("WebAPITokens").GetValue<string>("Git");

            using (var httpClient = new HttpClient())
            {
                httpClient.DefaultRequestHeaders.Add("Authorization", "Basic " + gitToken);                

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
